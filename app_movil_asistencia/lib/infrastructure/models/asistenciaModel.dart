// To parse this JSON data, do
//
//     final horariosModel = horariosModelFromJson(jsonString);

import 'dart:convert';

HorariosModel horariosModelFromJson(String str) => HorariosModel.fromJson(json.decode(str));

String horariosModelToJson(HorariosModel data) => json.encode(data.toJson());

class HorariosModel {
    final int idHorario;
    final int idGrupo;
    final String dia;
    final String horaInicio;
    final String horaFin;
    final String nombre;
    final String codMateria;

    HorariosModel({
        required this.idHorario,
        required this.idGrupo,
        required this.dia,
        required this.horaInicio,
        required this.horaFin,
        required this.nombre,
        required this.codMateria,
    });

    factory HorariosModel.fromJson(Map<String, dynamic> json) => HorariosModel(
        idHorario: json["id_horario"],
        idGrupo: json["id_grupo"],
        dia: json["dia"],
        horaInicio: json["horaInicio"],
        horaFin: json["horaFin"],
        nombre: json["nombre"],
        codMateria: json["cod_materia"],
    );

    Map<String, dynamic> toJson() => {
        "id_horario": idHorario,
        "id_grupo": idGrupo,
        "dia": dia,
        "horaInicio": horaInicio,
        "horaFin": horaFin,
        "nombre": nombre,
        "cod_materia": codMateria,
    };
}
