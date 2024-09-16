import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import Comp from './components/Index.jsx'
import PostEx from './components/PostEx.jsx'
ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <PostEx />
  </React.StrictMode>,
)
