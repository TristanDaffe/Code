import { createStore, combineReducers } from "redux";
const liste = [
	{
		id: 1,
		prenom: "John",
		nom: "Doe",
		age: 47,
	},
	{
		id: 2,
		prenom: "Bob",
		nom: "Boyar",
		age: 56,
	},
	{
		id: 3,
		prenom: "Alice",
		nom: "Doyen",
		age: 45,
	},
	{
		id: 4,
		prenom: "Charlie",
		nom: "Tango",
		age: 48,
	},
	{
		id: 5,
		prenom: "Danielle",
		nom: "Eden",

		age: 49,
	},
];
const employeReducer = (state = { listeEmployes: liste }, action) => {
	const listeEmployes = state.listeEmployes;
	const newArray = [...listeEmployes];
	switch (action.type) {
		case "updateEmploye":
			const updatedEmploye = action.payload.newEmploye;
			const index = newArray.findIndex((em) => em.id === updatedEmploye.id);
			newArray[index] = updatedEmploye;
			return {
				listeEmployes: newArray,
			};
		case "addEmploye":
			const newEmploye = action.payload.newEmploye;
			newEmploye.id = newArray.length + 1;
			newArray.push(newEmploye);
			return {
				listeEmployes: newArray,
			};
		default:
			return state;
	}
};

const store = createStore(combineReducers({ employes: employeReducer }));
export default store;
