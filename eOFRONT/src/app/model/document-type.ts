export class DocumentType implements DocumentTypeInterface {
    public id?:number;
    public name:String;
    public code:String;

    constructor(documentTypeConf:DocumentTypeInterface){
        this.id=documentTypeConf.id;
        this.name=documentTypeConf.name;
        this.code=documentTypeConf.code;
    }
}
interface DocumentTypeInterface{
    id?:number;
    name:String;
    code:String;
}
