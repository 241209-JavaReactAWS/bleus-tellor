import { Item } from "./Item"

export interface Customer {
    customerId : number,
    userName : string,
    userPassword : string,
    itemCart : Item[],
    role : "ADMIN" | "CUSTOMER"
}