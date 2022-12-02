import {configureStore} from '@reduxjs/toolkit';

const liste = [
    {
        id: 1,
        date : "22/01/2022",
        time : "10:00",
        donor : "Daffe Tristan",
        donationType : "Plasma",
        bloodType : "O+",
        donationCenter : "Centre de don de sang de Paris",
    },
    {
        id: 2,
        date : "12/03/2022",
        time : "12:00",
        donor : "Daffe Tristan",
        donationType : "Plasma",
        bloodType : "O+",
        donationCenter : "Centre de don de sang de Chatelet",
    },
    {
        id: 3,
        date : "04/05/2022",
        time : "10:00",
        donor : "Dieudonné Nicolas",
        donationType : "Blood",
        bloodType : "A+",
        donationCenter : "Centre de don de sang de Namur",
    },
    {
        id: 4,
        date : "04/05/2022",
        time : "13:00",
        donor : "Goffinet Flavien",
        donationType : "Blood",
        bloodType : "B-",
        donationCenter : "Centre de don de sang de Charleroi",
    },
    {
        id: 5,
        date : "06/11/2022",
        time : "08:00",
        donor : "Daffe Tristan",
        donationType : "Blood",
        bloodType : "B-",
        donationCenter : "Centre de don de sang de Charleroi",
    }
];

const donationReducer = (state = {listeDonations: liste}, action) => {
    const listeDonations = state.listeDonations;
    const newArray = [...listeDonations];
    switch (action.type) {
        case "updateDonation":
            const updatedDonation = action.payload.newDonation;
            const index = newArray.findIndex(em => em.id === updatedDonation.id);
            newArray[index] = updatedDonation;
            return {
                listeDonations: newArray
            }
        case "addDonation":
            const newDonation = action.payload.newDonation;
            newDonation.id = newArray.length + 1;
            newArray.push(newDonation);
            return {
                listeDonations: newArray
            }

        default:
            return state;
    }
};


const store = configureStore({reducer: {donations: donationReducer}});

export default store;