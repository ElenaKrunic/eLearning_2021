
export class TypeOfFinancing implements TypeOfFinancingInterface{
    public id?:number;
    public name:String;
    public code:String;
    constructor(typeOfFinancingConf:TypeOfFinancingInterface){
        this.id=typeOfFinancingConf.id;
        this.name=typeOfFinancingConf.name;
        this.code=typeOfFinancingConf.code;
    }
}
interface TypeOfFinancingInterface{
    id?:number;
    name:String;
    code:String;

}
