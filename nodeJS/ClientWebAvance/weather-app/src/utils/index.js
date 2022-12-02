import list from './city.list';

const convertNameToID = (name) => {
    const nameLower = name.toLowerCase();
    return list.find(elem => elem.name.toLowerCase() === nameLower)?.id;
};

export {
    convertNameToID
}