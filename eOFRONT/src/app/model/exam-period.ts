import { Identifiers } from "@angular/compiler";
export class ExamPeriod  implements ExamPeriodInterface {

    public id?: number;
    public name: string;
    public startDate: string;
    public endDate: string;
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
    startDate: string;
    endDate: string;
    paymentAmount: number;
}
