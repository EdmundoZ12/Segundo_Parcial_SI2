import 'package:app_movil_asistencia/infrastructure/models/materiModel.dart';
import 'package:dio/dio.dart';
import 'package:jwt_decode/jwt_decode.dart';
import 'package:shared_preferences/shared_preferences.dart';

class GetMaterias {
  final Dio dio = Dio();

  Future<List<MateriasModel>> getMaterias() async {
    try {
      // Obtener el token de SharedPreferences
      final prefs = await SharedPreferences.getInstance();
      final token = prefs.getString('token');
      if (token == null) {
        throw Exception('Token no encontrado');
      }

      // Decodificar el token JWT para obtener el número de registro
      Map<String, dynamic> payload = Jwt.parseJwt(token);
      final registro = payload['nro_registro'];
      if (registro == null || !(registro is String)) {
        throw Exception('Número de registro no encontrado o no es una cadena en el token');
      }

      // Realizar la solicitud HTTP
      final response = await dio.get(
        'https://segundo-parcial-si2.onrender.com/api/docente-materia/materias/$registro',
        options: Options(
          headers: {
            'Authorization': 'Bearer $token',
          },
        ),
      );

      // Manejar la respuesta
      if (response.statusCode == 200) {
        final List<dynamic> materiasJson = response.data;
        List<MateriasModel> materias = materiasJson
            .map((json) => MateriasModel.fromJson(json))
            .toList();
        return materias;
      } else {
        throw Exception('Failed to load materias');
      }
    } catch (e) {
      print('Error fetching materias: $e');
      throw Exception('Failed to load materias');
    }
  }
}
