export class User implements UserInterface{

        public id?: number;
        public username: string;
        public password: string;
    
        // dodati deo za userauthority da moze admin dodati ulogu za novog korisnika
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
