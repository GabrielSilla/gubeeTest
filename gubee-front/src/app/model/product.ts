import { Stack } from "./stack";
import { TargetMarket } from "./target-market";

export class Product {
    id: number;
    productName: string;
    description: string;
    stack: Array<Stack>;
    targetMarket: Array<TargetMarket>;
}