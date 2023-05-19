import { Inmueble } from "./Inmueble";
import { Usuario } from "./Usuario";

export interface Peticion {
    idpeticion: number |undefined;
    estado: string;
    cliente:Usuario;
    inmueble:Inmueble|undefined;
}