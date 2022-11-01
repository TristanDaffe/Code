import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import CityInfo from "../component/CityInfo";

export default function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/city/:city" element={<CityInfo />} />
        {/* <Route path="/" element={<CompareCity />} /> */}
      </Routes>
    </BrowserRouter>
  );
}
