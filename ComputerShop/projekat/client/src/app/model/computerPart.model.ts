import { Brand } from "./brand.model";

export class ComputerPart {
    constructor(
        public id:number,
        public name:string,
        public price:number,
        public brand: Brand
    )
    {}
}