import { DocumentType } from "./document-type";
import { Student } from "./student";

export class Document implements DocumentInterface{
    public  id?:number;
	public  title:String;
	public  url:String;
    public student:Student;
    public documentType:DocumentType;
    constructor(documentConf:DocumentInterface){
        this.id=documentConf.id;
        this.title=documentConf.title;
        this.url=documentConf.url;
        this.student=documentConf.student;
        this.documentType=documentConf.documentType;
    }
}
interface DocumentInterface{
    id?:number;
      title:String;
	  url:String;
     student:Student;
     documentType:DocumentType;
    
}
