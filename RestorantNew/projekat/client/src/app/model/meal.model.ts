import { Category } from "./category.model";

export class Meal{
    constructor(
        public id: number,
        public name: string,
        public category: Category,
        public price: number
    ){}
}