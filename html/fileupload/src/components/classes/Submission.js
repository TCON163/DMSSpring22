export default class Submission{


    constructor(id, customerName) {
        this.id = id;
        this.customerName = customerName;
    }



    static getSubmissions(){

        const s1 = new Submission(1,"BrickYard");
        const s2 = new Submission(2,"Saddle Up");
        const s3 = new Submission(3, "The Garage");
        const s4 = new Submission(4,"Haberdasher");
        const s5 = new Submission(5, "Veets");
        const s6 = new Submission(6, "Stables");

        let list = [];

        list.push(s1);
        list.push(s2);
        list.push(s3);
        list.push(s4);
        list.push(s5);
        list.push(s6);

        return list;

    }
}