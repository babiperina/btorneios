// import { useState } from "react";
import "./App.css";
import { CardPlayer } from "./components/card/cardPlayer";
import PlayerData from "./interface/PlayerData";

function App() {
  const data: PlayerData[] = [];

  return (
    <div className="container">
      <h1>score4you</h1>
      <div className="player-grid">
        {data.map((playerData) => (
          <CardPlayer
            firstName={playerData.firstName}
            lastName={playerData.lastName}
            email={playerData.email}
          />
        ))}
      </div>
    </div>
  );
}

export default App;
