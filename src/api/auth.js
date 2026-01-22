

export const loginBasicAuth = (username,password)=>{
  const authHeader = "Basic"+btoa(username+":"+password);
  localStorage.setItem("auth",authHeader);
}

export const logout=()=>{
  localStorage.removeItem("auth");
}

export const isAuthenticated=()=>{
  return !!localStorage.getItem("auth");
}