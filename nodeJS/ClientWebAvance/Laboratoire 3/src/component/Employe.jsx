import React from 'react';
import {connect} from 'react-redux';
import {Navigate, useParams} from 'react-router-dom';

function withParams(Component) {
    return (props) => {return <Component {...props} params={useParams()} />};
}

class Employe extends React.Component{

    constructor(props) {
        super(props);
        const employes = this.props.employes;
        const id = parseInt(this.props.params.id);
        const [employe] = employes.filter(e => e.id === id);
        this.state = {
            id,
            nom: employe.nom,
            prenom: employe.prenom,
            age: employe.age,
            redirect: false
        }
    }

    sauvegarder(event){
        event.preventDefault();
        this.props.updateEmploye({
            id: this.state.id,
            nom: this.state.nom,
            prenom: this.state.prenom,
            age: this.state.age
        });
        this.setState({redirect: true});
    }

    render(){
        return(
            <form>
                <label>Nom:</label>
                <input type="text"
                       value={this.state.nom}
                       onChange={(e) => this.setState({nom: e.target.value})}
                />
                <label>Prenom:</label>
                <input type="text"
                       value={this.state.prenom}
                       onChange={(e) => this.setState({prenom: e.target.value})}
                />
                <label>Age</label>
                <input type="number"
                       value={this.state.age}
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
        employes : state.employes.listeEmployes
    }
};

const mapDispatchToProps = (dispatch) => {
    return {
        updateEmploye: (employeObjet) => {
            dispatch({type: "updateEmploye", payload:{newEmploye: employeObjet}});
        }
    }
};

export default withParams(connect(mapStateToProps, mapDispatchToProps)(Employe));