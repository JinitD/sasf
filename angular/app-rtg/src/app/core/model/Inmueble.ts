import { Usuario } from "./Usuario";

export interface Inmueble {
    idinmueble: number;
    direccion: string;
    estado: string;
    precio: number;
    tipo: string;
    empleado: Usuario;
}