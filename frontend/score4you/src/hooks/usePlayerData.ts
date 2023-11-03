import axios, { AxiosPromise } from "axios";
import { PlayerData } from "./../interface/PlayerData";
import { useQuery } from "@tanstack/react-query";

const API_URL = "http://localhost:8080";

const fetchData = async (): AxiosPromise<PlayerData[]> => {
  const response = axios.get(API_URL + "/player");
  return response;
};

export function usePlayerData() {
  const query = useQuery({
    queryFunction: fetchData,
    queryKey: ["player-data"],
    retry: 2,
  });

  return {
    ...query,
    data: query.data?.data,
  };
}
