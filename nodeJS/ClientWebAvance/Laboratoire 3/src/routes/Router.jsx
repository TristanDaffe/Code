import React from "react";
import {
    BrowserRouter,
    Routes,
    Route,
} from "react-router-dom";
import SearchForm from '../component/SearchForm';
import Donation from '../component/Donation';

export default function Router(){
    return(
        <BrowserRouter>
            <Routes>
                <Route path="/donation/:id" element={<Donation/>}/>
                <Route path="/" element={<SearchForm/>}/>
            </Routes>
        </BrowserRouter>
    );
}