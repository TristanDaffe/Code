import React from 'react';
import Search from '../../component/Search';

const DoubleSearch = () => {
    return (
        <div className="doubleSearchBox">
            <Search/>
            <Search/>
        </div>
    );
};

export default DoubleSearch;