import { Empleado } from "./Empleado";

export interface Inmueble {
    idinmueble: number;
    direccion: string;
    estado: string;
    precio: number;
    tipo: string;
    empleado: Empleado;
}