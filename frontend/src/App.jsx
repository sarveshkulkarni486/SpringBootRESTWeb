import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Login from './components/Login'
import Register from './components/Register'
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <Router>
      <div>
        <nav>
          <ul className="flex space-x-4">
            <li>
              <Link to="/register" className="text-indigo-600 hover:text-indigo-500">Register</Link>
            </li>
            <li>
              <Link to="/login" className="text-indigo-600 hover:text-indigo-500">Login</Link>
            </li>
          </ul>
        </nav>

        <Routes>
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
        </Routes>
      </div>
    </Router>

    </>
  )
}

export default App
