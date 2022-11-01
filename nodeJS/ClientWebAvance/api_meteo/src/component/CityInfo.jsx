import React from "react";
//import { connect } from "react-redux";
import { Navigate, useParams } from "react-router-dom";
function withParams(Component) {
	return (props) => <Component {...props} params={useParams()} />;
}

class CityInfo extends React.Component {
    constructor(props) {
        super(props);
        const city = this.props.city;
        this.state ={
            city: city,
            redirect: false,
        }
    }
}

export default (CityInfo);
