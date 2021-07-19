export class Authority{
	public id: number;
	public name: string;
		
	constructor(authorityCfg: Authority)
	{	
		this.id = authorityCfg.id;
        this.name = authorityCfg.name;			
	}
}