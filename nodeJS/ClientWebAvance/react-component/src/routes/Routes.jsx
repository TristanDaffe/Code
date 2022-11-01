import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import SearchForm from "../component/SearchForm";
import Employe from "../component/Employe";

export default function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/employe/:id" element={<Employe />} />
        <Route path="/" element={<SearchForm />} />
      </Routes>
    </BrowserRouter>
  );
}
