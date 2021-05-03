import { Identifiers } from "@angular/compiler";
export class ExamPeriod  implements ExamPeriodInterface {

    public id?: number;
    public name: string;
    public startDate: Date;
    public endDate: Date;
    public paymentAmount: number;

    constructor(examPeriodCfg: ExamPeriodInterface) {
        this.id= examPeriodCfg.id;
        this.name= examPeriodCfg.name;
        this.startDate= examPeriodCfg.startDate;
        this.endDate= examPeriodCfg.endDate;
        this.paymentAmount= examPeriodCfg.paymentAmount;
    }
}

interface ExamPeriodInterface {
    id?: number;
    name: string;
    startDate: Date;
    endDate: Date;
    paymentAmount: number;
}
