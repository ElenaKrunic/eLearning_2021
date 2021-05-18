export class User implements UserInterface{

        public id?: number;
        public username: string;
        public password: string;
    
        constructor(userConf:UserInterface) {
            this.id= userConf.id;
            this.username= userConf.username;
            this.password=userConf.password;
        }
    }

interface UserInterface{
    id?:number;
    username:string;
    password:string;
}
