
class MateriasModel {
    final String codMateria;
    final int idGrupo;
    final String nombreMateria;
    final String nombreGrupo;

    MateriasModel({
        required this.codMateria,
        required this.idGrupo,
        required this.nombreMateria,
        required this.nombreGrupo,
    });

    factory MateriasModel.fromJson(Map<String, dynamic> json) => MateriasModel(
        codMateria: json["cod_materia"],
        idGrupo: json["id_grupo"],
        nombreMateria: json["nombre_materia"],
        nombreGrupo: json["nombre_grupo"],
    );

    Map<String, dynamic> toJson() => {
        "cod_materia": codMateria,
        "id_grupo": idGrupo,
        "nombre_materia": nombreMateria,
        "nombre_grupo": nombreGrupo,
    };
}
