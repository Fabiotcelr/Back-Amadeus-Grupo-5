package com.example.apiRest.Services;
import com.example.apiRest.Interfaces.BaseServiceInfo;
import com.example.apiRest.Models.DestinoInfo;
import com.example.apiRest.Models.DestinoRequest;
import com.example.apiRest.Models.DestinoResponse;
import com.example.apiRest.Models.User;
import com.example.apiRest.Repositories.destinoInfoRespository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.apiRest.Repositories.destinoInfoRespository;

import java.util.List;

@Service
public class DestinoService implements BaseServiceInfo {

    private final destinoInfoRespository destinoInfoRespository;

    public DestinoService(destinoInfoRespository destinoInfoRespository) {
        this.destinoInfoRespository = destinoInfoRespository;
    }

    // Método para enviar destino
    public DestinoResponse enviarDestino(String pDestino, String pClimatica, String pActividad, String pAlojamiento, String dViaje, String edad) {

        DestinoRequest destinoRequest = new DestinoRequest(pDestino, pClimatica, pActividad, pAlojamiento, dViaje, edad);

        // Reseteamos destinos antes de procesar
        String destinoA = "";
        String destinoE = "";

        // Lógica principal
        switch (pDestino) {
            // Si el destino es playa
            case "Playa":
                if ("Caluroso".equals(pClimatica)) {
                    switch (dViaje) {
                        case "1-2 semanas":
                            if ("Menos de 30 años".equals(edad) && "Deportes y Aventuras".equals(pActividad) && "Hostal o Albergue".equals(pAlojamiento)) {
                                destinoA = "Tulum";
                                destinoE = "Ibiza";
                            } else if ("Menos de 30 años".equals(edad) && "Relax y Bienestar".equals(pActividad) && "Hotel de Lujo".equals(pAlojamiento)) {
                                destinoA = "Playa del Carmen";
                                destinoE = "Santorini";
                            } else if ("30-50 años".equals(edad) && "Cultura y Museos".equals(pActividad) && "Hotel de Lujo".equals(pAlojamiento)) {
                                destinoA = "Honolulu";
                                destinoE = "Malta";
                            }
                            break;
                        case "Menos de una semana":
                            if ("Menos de 30 años".equals(edad) && "Cultura y Museos".equals(pActividad) && "Airbnb".equals(pAlojamiento)) {
                                destinoA = "Cartagena";
                                destinoE = "Barcelona";
                            }
                            break;
                    }
                } else if ("Templado".equals(pClimatica)) {
                    switch (dViaje) {
                        case "1-2 semanas":
                            if ("Menos de 30 años".equals(edad) && "Cultura y Museos".equals(pActividad) && "Hostal o Albergue".equals(pAlojamiento)) {
                                destinoA = "San Juan";
                                destinoE = "Niza";
                            } else if ("30-50 años".equals(edad) && "Cultura y Museos".equals(pActividad) && "Hotel de Lujo".equals(pAlojamiento)) {
                                destinoA = "Río de Janeiro";
                                destinoE = "Lisboa";
                            }
                            break;
                        case "Más de dos semanas":
                            if ("Más de 50 años".equals(edad) && "Relax y Bienestar".equals(pActividad) && "Airbnb".equals(pAlojamiento)) {
                                destinoA = "Punta Cana";
                                destinoE = "Algarve";
                            }
                            break;
                    }
                }
                break;
            // Si el destino es Montaña
            case "Montaña":
                if ("Frío".equals(pClimatica) && "1-2 semanas".equals(dViaje)) {
                    if ("Más de 50 años".equals(edad) && "Airbnb".equals(pAlojamiento)) {
                        if ("Cultura y Museos".equals(pActividad)) {
                            destinoA = "Ushuaia";
                            destinoE = "Reykjavik";
                        } else if ("Relax y Bienestar".equals(pActividad)) {
                            destinoA = "Aspen";
                            destinoE = "Innsbruck";
                        }
                    } else if ("Menos de 30 años".equals(edad) && "Hostal o Albergue".equals(pAlojamiento) && "Deportes y Aventuras".equals(pActividad)) {
                        destinoA = "Bariloche";
                        destinoE = "Interlaken";
                    } else if ("30-50 años".equals(edad) && "Hotel de Lujo".equals(pAlojamiento) && "Deportes y Aventuras".equals(pActividad)) {
                        destinoA = "Banff";
                        destinoE = "Zermatt";
                    }
                } else if ("Templado".equals(pClimatica) && "1-2 semanas".equals(dViaje)) {
                    if ("Más de 50 años".equals(edad) && "Airbnb".equals(pAlojamiento) && "Cultura y Museos".equals(pActividad)) {
                        destinoA = "Cusco";
                        destinoE = "Granada";
                    } else if ("Menos de 30 años".equals(edad) && "Airbnb".equals(pAlojamiento) && "Deportes y Aventuras".equals(pActividad) && "Más de dos semanas".equals(dViaje)) {
                        destinoA = "Machu Picchu";
                        destinoE = "Chamonix";
                    }
                }
                break;
            // Si el destino es Ciudad
            case "Ciudad":
                if ("Caluroso".equals(pClimatica) && "1-2 semanas".equals(dViaje) && "Más de 50 años".equals(edad) && "Hotel de Lujo".equals(pAlojamiento) && "Cultura y Museos".equals(pActividad)) {
                    destinoA = "Los Angeles";
                    destinoE = "Roma";
                } else if ("Frío".equals(pClimatica) && "1-2 semanas".equals(dViaje) && "30-50 años".equals(edad) && "Hotel de Lujo".equals(pAlojamiento) && "Cultura y Museos".equals(pActividad)) {
                    destinoA = "Toronto";
                    destinoE = "Berlín";
                } else if ("Templado".equals(pClimatica) && "1-2 semanas".equals(dViaje) && "Cultura y Museos".equals(pActividad)) {
                    if ("30-50 años".equals(edad) && "Hostal o Albergue".equals(pAlojamiento)) {
                        destinoA = "Ciudad de México";
                        destinoE = "Madrid";
                    } else if ("Más de 50 años".equals(edad) && "Hotel de Lujo".equals(pAlojamiento)) {
                        destinoA = "Nueva York";
                        destinoE = "París";
                    }
                } else if ("Templado".equals(pClimatica) && "Menos de una semana".equals(dViaje)) {
                    if ("Menos de 30 años".equals(edad) && "Airbnb".equals(pAlojamiento) && "Relax y Bienestar".equals(pActividad)) {
                        destinoA = "Miami";
                        destinoE = "Viena";
                    } else if ("30-50 años".equals(edad) && "Hotel de Lujo".equals(pAlojamiento) && "Deportes y Aventuras".equals(pActividad)) {
                        destinoA = "Chicago";
                        destinoE = "Londres";
                    }
                }
                break;
        }

        // Si no se ha asignado ningún destino, sugerimos alternativas predeterminadas
        if (destinoA.isEmpty()) {
            destinoA = "Bora Bora";
            destinoE = "Dubái";
        }

        // Crear el objeto con los destinos seleccionados
        DestinoResponse destinoResponse = new DestinoResponse(destinoA, destinoE);

        // Guardar los destinos de el usuario en la base de datos
        //destinoRepository.save(destinoRequest);

        // Asignamos los destinos
        return destinoResponse;
    }

//    public DestinoInfo saveDestinity(DestinoInfo destinoInfo) {
//        return destinoInfoRespository.save(destinoInfo);
//    }

    @Override
    public DestinoInfo create(DestinoInfo destinoInfo) {
        return destinoInfoRespository.saveAndFlush(destinoInfo);
    }

    public List<DestinoInfo> searchName(String nombreDestino) {
        return destinoInfoRespository.searchName(nombreDestino);
    }
}
