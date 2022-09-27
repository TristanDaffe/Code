class Car {
    constructor(engine, color, speed, wheels = 4){
        this.wheels = wheels;
        this.team = "";
        this.gas = 0;
        this.engine = engine;
        this.color = color;
        this.speed = speed;
    }

    print(){
        console.log(this.team + " F1 Car => " + this.engine + " " + this.speed +"\n");
    }

    fillGas(){
        this.gas = 14500;
    }

    checkEngine(){
        return typeof this.engine !== "undefined";
    }
    checkWheels(){
        return this.wheels === 4;
    }
}

class Ferrari extends Car {
    constructor(pilot, aerodynamic){
        super("v8", "red", 250, );
        this.team = "Ferrari";
        this.pilot = pilot;
        this.aerodynamic = aerodynamic;
    }
}

class Mclaren extends Car {
    constructor(pilot, turbo){
        super("v6", "orange", 240);
        this.team = "Mclaren";
        this.pilot = pilot;
        this.turbo = turbo;
    }
}

class Redbull extends Car {
    constructor(pilot, wheels){
        super("v12", "blue", 260, wheels);
        this.team = "Redbull";
    }
}

function getTeams(cars){
    let teams = [];
}