import { Category } from "./category.model";


export class Article{
    constructor(
        public id:number,
        public title:string,
        public text:string,
        public category:Category
    )
    {}
}