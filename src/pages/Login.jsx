import React, { useState } from 'react'
import api from '../api/axios';
import { loginBasicAuth } from '../api/auth';
import { Navigate, useNavigate } from 'react-router-dom';

function Login() {
  const [username,setUsername]=useState("");
  const[password,setPassword]=useState("");
  const navigate = useNavigate();
  const login= async()=>{
    const authHeader ="Basic "+btoa(username+":"+password);
    try{
      const response=await api.get("/admin",{
        headers:{Authorization:authHeader}
      })
      console.log(response);
      loginBasicAuth(username,password);
      navigate("/dashboard");
    }catch(error){
      alert("Invalid Credentials");
    }
  }
  return (
    <div>
      <h1>Admin Login</h1>
      <input type="text" placeholder='Username'aria-label='Username'
      onChange={e=>setUsername(e.target.value)}
      />
      <input type="password"placeholder='Password'aria-label='password' 
      onChange={e=>setPassword(e.target.value)}
      />
      <button
        onClick={login}
      >Login</button>
    </div>
  )
}

export default Login
