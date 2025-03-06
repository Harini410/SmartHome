"use client";
import { useEffect } from "react";

export default function SyntheticV0PageForDeployment() {
  useEffect(() => {
    // Create a script element
    const script = document.createElement("script");
    script.src = "http://localhost:8080/script.js"; // Load from Spring Boot
    script.async = true;
    document.body.appendChild(script);

    return () => {
      // Cleanup: Remove script on unmount
      document.body.removeChild(script);
    };
  }, []);

  return (
    <div>
      <h1>Welcome to SmartHome</h1>
      <p>Energy management system</p>
    </div>
  );
}
