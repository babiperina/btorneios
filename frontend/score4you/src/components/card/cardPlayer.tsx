import "./cardPlayer.css";

interface CardProps {
  firstName: string;
  lastName: string;
  email: string;
}
export function CardPlayer({ firstName, lastName, email }: CardProps) {
  return (
    <div className="player-card">
      <h2>
        {firstName} {lastName}
      </h2>
      <p>{email}</p>
    </div>
  );
}
