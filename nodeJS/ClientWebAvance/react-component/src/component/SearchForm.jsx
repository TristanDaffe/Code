import React from "react";
import SearchBar from "./SearchBar";
import { Link } from "react-router-dom";
import {connect} from 'react-redux';
import {Navigate} from 'react-router-dom';

class SearchForm extends React.Component {
	constructor(props) {
		super(props);
		this.state = {
			employes: this.props.employes,
			employesToShow: this.props.employes,
			inputNom: "",
			inputPrenom: "",
			inputAge: "",
		};
	}
	addEmploye(event) {
		event.preventDefault();
		const newEmploye = {
			nom: this.state.inputNom,
			prenom: this.state.inputPrenom,
			age: parseInt(this.state.inputAge),
		};
		this.props.addEmploye(newEmploye);
	}
	changeValuesToShow(string) {
		const employesToShow = this.state.employes;
		const afterFiltering = employesToShow.filter((emp) => {
			return emp.nom.includes(string);
		});
		this.setState({ employesToShow: afterFiltering });
	}

	componentDidUpdate(prevProps) {
		if (this.props !== prevProps) {
			this.setState({
				employes: this.props.employes,
				employesToShow: this.props.employes,
			});
		}
	}

	render() {
		return (
			<div>
				<SearchBar
					callback={(searchValue) => this.changeValuesToShow(searchValue)}
				/>
				<table>
					<thead>
						<tr>
							<th>nom</th>

							<th>prenom</th>
							<th>age</th>
							<th>Voir plus d'info</th>
						</tr>
					</thead>
					<tbody>
						{this.state.employesToShow.map((emp, index) => {
							return (
								<tr key={index}>
									<td>{emp.nom}</td>
									<td>{emp.prenom}</td>
									<td>{emp.age}</td>
									<td>
										<Link to={`/employe/${emp.id}`}>Lien</Link>
									</td>
								</tr>
							);
						})}
					</tbody>
				</table>
				<form>
					<label>Nom:</label>
					<input
						type="text"
						onChange={(event) => {
							this.setState({ inputNom: event.target.value });
						}}
					/>
					<label>Prenom:</label>
					<input
						type="text"
						onChange={(event) => {
							this.setState({ inputPrenom: event.target.value });
						}}
					/>
					<label>Age:</label>
					<input
						type="number"
						onChange={(event) => {
							this.setState({ inputAge: event.target.value });
						}}
					/>

					<button onClick={(event) => this.addEmploye(event)}>Ajouter</button>
				</form>
			</div>
		);
	}
}

const mapStateToProps = (state) => {
	return {
		employes: state.employes.listeEmployes,
	};
};
const mapDispatchToProps = (dispatch) => {
	return {
		addEmploye: (employeObjet) => {
			dispatch({ type: "addEmploye", payload: { newEmploye: employeObjet } });
		},
	};
};

export default connect(mapStateToProps, mapDispatchToProps)(SearchForm);
