export default class File{
    constructor(id, fileName, subId, folder, subFolder){
        this.id = id;
        this.fileName = fileName;
        this.subId = subId;
        this.folder = folder;
        this.subFolder = subFolder;



    }

    static list = []

    static setFiles(){

            let count = 0;
            for(let i = 0; i<6;i++){
                const app1 = new File(++count,`Acord 125 ${i+1}`, i+1,"ARTQ", "App")
                const app2 = new File(++count,`Acord 126 ${i+1}`, i+1,"ARTQ", "App")
                const lossRun = new File(++count,`loss runs ${i+1}`, i+1,"Loss Runs", "Loss")   
                const supp = new File(++count,`Supplemental ${i+1}`, i+1,"ARTQ", "Supp")
                const policy = new File(++count,`Policy ${i+1}`, i+1,"Policy", "PLY")
                const quote = new File(++count,`Quote ${i+1}`,i+1,"Quotes","QTE")
                this.list.push(app1)
                this.list.push(app2)
                this.list.push(lossRun)
                this.list.push(supp)
                this.list.push(policy)
                this.list.push(quote)
            }
        

        
          

    }


    static getFiles(id){
        if(this.list.length<1){
            this.setFiles()
        }

        
        return this.list.filter(file => file.subId ===id)
        
    }


    static getFile(id){
        return this.list.filter(file => file.id ===id)[0]
    }

toString(){
    return `fileId: ${this.id}, fileName: ${this.fileName}`
}

}