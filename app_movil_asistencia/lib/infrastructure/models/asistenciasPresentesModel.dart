class AsistenciasModel {
  final DateTime fecha;
  final String hora;
  final String motivo;
  final String modalidad;
  final String nombreMateria;

  AsistenciasModel({
    required this.fecha,
    required this.hora,
    required this.motivo,
    required this.modalidad,
    required this.nombreMateria,
  });

  factory AsistenciasModel.fromJson(Map<String, dynamic> json) {
    return AsistenciasModel(
      fecha: DateTime.parse(json["fecha"]),
      hora: json["hora"]??"",
      motivo: json["motivo"] ?? "", // Asignar cadena vacía si es nulo
      modalidad: json["modalidad"]??"",
      nombreMateria: json["nombre_materia"],
    );
  }

  Map<String, dynamic> toJson() => {
    "fecha": fecha.toIso8601String(),
    "hora": hora,
    "motivo": motivo,
    "modalidad": modalidad,
    "nombre_materia": nombreMateria,
  };
}
