import { useState, useEffect } from 'react'
import { Activity, Users, Zap, AlertCircle, RefreshCw, Layers } from 'lucide-react'
import './App.css'

function App() {
  const [metrics, setMetrics] = useState(null)
  const [projects, setProjects] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)

  const fetchData = async () => {
    setLoading(true)
    try {
      const metricsRes = await fetch('http://localhost:8080/api/v1/dashboard/metrics')
      const projectsRes = await fetch('http://localhost:8080/api/v1/projects')

      if (!metricsRes.ok || !projectsRes.ok) throw new Error('Failed to fetch data')

      const metricsData = await metricsRes.json()
      const projectsData = await projectsRes.json()

      setMetrics(metricsData)
      setProjects(projectsData)
      setError(null)
    } catch (err) {
      setError('Backend service might be offline. Run ./gradlew bootRun to start it.')
      console.error(err)
    } finally {
      setLoading(false)
    }
  }

  useEffect(() => {
    fetchData()
  }, [])

  if (loading) {
    return (
      <div className="loading-spinner">
        <RefreshCw className="spin" size={48} />
      </div>
    )
  }

  if (error) {
    return (
      <div className="dashboard">
        <div className="card" style={{ textAlign: 'center', borderColor: 'var(--error)' }}>
          <AlertCircle size={48} color="var(--error)" style={{ marginBottom: '1rem' }} />
          <h2 style={{ color: 'var(--error)' }}>Connection Error</h2>
          <p>{error}</p>
          <button onClick={fetchData} className="badge badge-in-progress" style={{ marginTop: '1rem', cursor: 'pointer', border: 'none' }}>
            Retry Connection
          </button>
        </div>
      </div>
    )
  }

  return (
    <div className="dashboard">
      <header>
        <div>
          <h1>Global Web Engineering</h1>
          <p className="subtitle">Dashboard | American Express</p>
        </div>
        <div className="badge badge-in-progress">Q1 FY2026</div>
      </header>

      <div className="metrics-grid">
        <div className="card">
          <div className="metric-label"><Users size={16} /> Active Users (Web)</div>
          <div className="metric-value">{(metrics.activeUsers / 1000000).toFixed(1)}M</div>
          <div className="metric-trend trend-up">▲ 4.2% from last month</div>
        </div>

        <div className="card">
          <div className="metric-label"><Activity size={16} /> System Health</div>
          <div className="metric-value">{metrics.systemHealth}%</div>
          <div className="metric-trend trend-up">▲ 0.02% uptime</div>
        </div>

        <div className="card">
          <div className="metric-label"><Zap size={16} /> Deployment Freq.</div>
          <div className="metric-value">{metrics.deploymentFrequency}</div>
          <div className="metric-trend">Weekly average</div>
        </div>

        <div className="card">
          <div className="metric-label"><AlertCircle size={16} /> Error Rate</div>
          <div className="metric-value">{metrics.errorRate}%</div>
          <div className="metric-trend trend-down">▼ 0.01% decrease</div>
        </div>
      </div>

      <div className="project-section">
        <div style={{ display: 'flex', alignItems: 'center', gap: '0.75rem', marginBottom: '1.5rem' }}>
          <Layers color="var(--primary)" />
          <h2 style={{ margin: 0 }}>Strategic Modernization Roadmap</h2>
        </div>
        <table>
          <thead>
            <tr>
              <th>Project Name</th>
              <th>Lead</th>
              <th>Status</th>
              <th>Progress</th>
            </tr>
          </thead>
          <tbody>
            {projects.map(proj => (
              <tr key={proj.id}>
                <td style={{ fontWeight: 600 }}>{proj.name}</td>
                <td>{proj.lead}</td>
                <td>
                  <span className={`badge badge-${proj.status.toLowerCase().replace(' ', '-')}`}>
                    {proj.status}
                  </span>
                </td>
                <td>
                  <div style={{ display: 'flex', alignItems: 'center', gap: '0.5rem' }}>
                    <div className="progress-bar">
                      <div className="progress-fill" style={{ width: `${proj.completionPercentage}%` }}></div>
                    </div>
                    <span>{proj.completionPercentage}%</span>
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default App
