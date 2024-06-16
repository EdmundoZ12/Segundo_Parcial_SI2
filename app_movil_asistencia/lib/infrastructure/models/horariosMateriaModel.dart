// To parse this JSON data, do
//
//     final horariosMateriaModel = horariosMateriaModelFromJson(jsonString);

import 'dart:convert';

HorariosMateriaModel horariosMateriaModelFromJson(String str) => HorariosMateriaModel.fromJson(json.decode(str));

String horariosMateriaModelToJson(HorariosMateriaModel data) => json.encode(data.toJson());

class HorariosMateriaModel {
    final int id;
    final String dia;
    final String horaInicio;
    final String horaFin;

    HorariosMateriaModel({
        required this.id,
        required this.dia,
        required this.horaInicio,
        required this.horaFin,
    });

    factory HorariosMateriaModel.fromJson(Map<String, dynamic> json) => HorariosMateriaModel(
        id: json["id"],
        dia: json["dia"],
        horaInicio: json["horaInicio"],
        horaFin: json["horaFin"],
    );

    Map<String, dynamic> toJson() => {
        "id": id,
        "dia": dia,
        "horaInicio": horaInicio,
        "horaFin": horaFin,
    };
}
