import React from 'react';
import {connect} from 'react-redux';
import {Navigate, useParams} from 'react-router-dom';

function withParams(Component) {
    return (props) => {return <Component {...props} params={useParams()} />};
}

class Donation extends React.Component{

    constructor(props) {
        super(props);
        console.log(props)
        const donations = this.props.donations;
        const id = parseInt(this.props.params.id);
        const [donation] = donations.filter(d => d.id === id);
        this.state = {
            id,
            date : donation.date,
            time : donation.time,
            donor : donation.donor,
            donationType : donation.donationType,
            bloodType : donation.bloodType,
            donationCenter : donation.donationCenter,
            redirect: false
        }
    }

    sauvegarder(event){
        event.preventDefault();
        this.props.updateDonation({
            id: this.state.id,
            date : this.state.date,
            time : this.state.time,
            donor : this.state.donor,
            donationType : this.state.donationType,
            bloodType : this.state.bloodType,
            donationCenter : this.state.donationCenter,
        });
        this.setState({redirect: true});
    }

    render(){
        return(
            <form>
                <label>Id:</label>
                <input type="text"
                       value={this.state.id}
                       onChange={(e) => this.setState({nom: e.target.value})}
                />
                <label>Date:</label>
                <input type="text"
                       value={this.state.date}
                       onChange={(e) => this.setState({prenom: e.target.value})}
                />
                <label>Donor</label>
                <input type="text"
                       value={this.state.donor}
                       onChange={(e) => this.setState({age: e.target.value})}
                />
                <label>Donation type</label>
                <input type="text"
                       value={this.state.donationType}
                       onChange={(e) => this.setState({age: e.target.value})}
                />
                <label>Blood type</label>
                <input type="text"
                       value={this.state.bloodType}
                       onChange={(e) => this.setState({age: e.target.value})}
                />
                <label>Donation Center</label>
                <input type="text"
                       value={this.state.donationCenter}
                       onChange={(e) => this.setState({age: e.target.value})}
                />
                <button
                    onClick={
                        (e) => this.sauvegarder(e)
                    }>
                    Sauvegarder
                </button>
                {this.state.redirect && <Navigate to={"/"}/>}
            </form>
        );
    }
}

const mapStateToProps = (state) => {
    return {
        donations : state.donations.listDonations
    }
};

const mapDispatchToProps = (dispatch) => {
    return {
        updateDonation: (donationObject) => {
            dispatch({type: "updateDonation", payload:{newDonation: donationObject}});
        }
    }
};

export default withParams(connect(mapStateToProps, mapDispatchToProps)(Donation));