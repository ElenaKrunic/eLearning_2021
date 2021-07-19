import { Authority } from "./authority";

export class User implements UserInterface{

        public id?: number;
        public username: string;
        public password: string;
        public authorities: Authority[];
    
        constructor(userConf:UserInterface) {
            this.id= userConf.id;
            this.username= userConf.username;
            this.password=userConf.password;
            this.authorities = userConf.authorities;
        }
    }

interface UserInterface{
    id?:number;
    username:string;
    password:string;
    authorities: Authority[];
}
