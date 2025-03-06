document.addEventListener("DOMContentLoaded", () => {
  // Get DOM elements
  const energyForm = document.getElementById("energyForm")
  const energyTableBody = document.getElementById("energyTableBody")
  const refreshBtn = document.getElementById("refreshBtn")

  // API URL
  const API_URL = "http://localhost:8080/energy"

  // Function to fetch all energy usage data
  async function fetchEnergyData() {
    try {
      const response = await fetch(`${API_URL}/all`)
      if (!response.ok) {
        throw new Error("Failed to fetch energy data")
      }
      const data = await response.json()
      displayEnergyData(data)
    } catch (error) {
      console.error("Error:", error)
      alert("Failed to fetch energy data. Make sure the backend server is running.")
    }
  }

  // Function to display energy data in the table
  function displayEnergyData(data) {
    // Clear existing table data
    energyTableBody.innerHTML = ""

    // Check if data is empty
    if (data.length === 0) {
      const row = document.createElement("tr")
      row.innerHTML = '<td colspan="4" style="text-align: center;">No energy data available</td>'
      energyTableBody.appendChild(row)
      return
    }

    // Add each energy usage record to the table
    data.forEach((usage) => {
      const row = document.createElement("tr")

      // Format the timestamp
      const timestamp = new Date(usage.timestamp)
      const formattedDate = timestamp.toLocaleDateString()
      const formattedTime = timestamp.toLocaleTimeString()

      row.innerHTML = `
                <td>${usage.id}</td>
                <td>${usage.appliance}</td>
                <td>${usage.energyConsumed}</td>
                <td>${formattedDate} ${formattedTime}</td>
            `

      energyTableBody.appendChild(row)
    })
  }

  // Function to add new energy usage data
  async function addEnergyUsage(energyData) {
    try {
      const response = await fetch(`${API_URL}/add`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(energyData),
      })

      if (!response.ok) {
        throw new Error("Failed to add energy data")
      }

      // Refresh the table after adding new data
      fetchEnergyData()

      return true
    } catch (error) {
      console.error("Error:", error)
      alert("Failed to add energy data. Make sure the backend server is running.")
      return false
    }
  }

  // Event listener for form submission
  energyForm.addEventListener("submit", (e) => {
    e.preventDefault()

    const appliance = document.getElementById("appliance").value
    const energyConsumed = Number.parseFloat(document.getElementById("energyConsumed").value)

    const energyData = {
      appliance: appliance,
      energyConsumed: energyConsumed,
    }

    addEnergyUsage(energyData).then((success) => {
      if (success) {
        // Reset form
        energyForm.reset()
      }
    })
  })

  // Event listener for refresh button
  refreshBtn.addEventListener("click", fetchEnergyData)

  // Fetch energy data when the page loads
  fetchEnergyData()
})

