// ignore: file_names
import 'package:app_movil_asistencia/infrastructure/models/asistenciasPresentesModel.dart';
import 'package:dio/dio.dart';
import 'package:jwt_decode/jwt_decode.dart';
import 'package:shared_preferences/shared_preferences.dart';

class GetControl {
  final Dio dio = Dio();

  Future<List<AsistenciasModel>> getRetrasos() async {
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
      if (registro == null || registro is! String) {
        throw Exception(
            'Número de registro no encontrado o no es una cadena en el token');
      }

      // Realizar la solicitud HTTP
      final response = await dio.get(
        'https://segundo-parcial-si2.onrender.com/api/docente-materia/retrasos/$registro',
        options: Options(
          headers: {
            'Authorization': 'Bearer $token',
          },
        ),
      );

      // Manejar la respuesta
      if (response.statusCode == 200) {
        final List<dynamic> materiasJson = response.data;
        List<AsistenciasModel> materias = materiasJson
            .map((json) => AsistenciasModel.fromJson(json))
            .toList();
        return materias;
      } else {
        throw Exception('Failed to load materias');
      }
    } catch (e) {
      throw Exception('Failed to load materias');
    }
  }

  Future<List<AsistenciasModel>> getFaltas() async {
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
      if (registro == null || registro is! String) {
        throw Exception(
            'Número de registro no encontrado o no es una cadena en el token');
      }

      // Realizar la solicitud HTTP
      final response = await dio.get(
        'https://segundo-parcial-si2.onrender.com/api/docente-materia/faltas/$registro',
        options: Options(
          headers: {
            'Authorization': 'Bearer $token',
          },
        ),
      );

      // Manejar la respuesta
      if (response.statusCode == 200) {
        final List<dynamic> materiasJson = response.data;
        List<AsistenciasModel> materias = materiasJson
            .map((json) => AsistenciasModel.fromJson(json))
            .toList();
        return materias;
      } else {
        throw Exception('Failed to load materias');
      }
    } catch (e) {
      throw Exception('Failed to load materias');
    }
  }

  Future<List<AsistenciasModel>> getAsistencias() async {
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
      if (registro == null || registro is! String) {
        throw Exception(
            'Número de registro no encontrado o no es una cadena en el token');
      }

      // Realizar la solicitud HTTP
      final response = await dio.get(
        'https://segundo-parcial-si2.onrender.com/api/docente-materia/asistencias/$registro',
        options: Options(
          headers: {
            'Authorization': 'Bearer $token',
          },
        ),
      );

      // Manejar la respuesta
      if (response.statusCode == 200) {
        final List<dynamic> materiasJson = response.data;
        List<AsistenciasModel> materias = materiasJson
            .map((json) => AsistenciasModel.fromJson(json))
            .toList();
        return materias;
      } else {
        throw Exception('Failed to load materias');
      }
    } catch (e) {
      throw Exception('Failed to load materias');
    }
  }

  Future<List<AsistenciasModel>> getLicencias() async {
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
      if (registro == null || registro is! String) {
        throw Exception(
            'Número de registro no encontrado o no es una cadena en el token');
      }

      // Realizar la solicitud HTTP
      final response = await dio.get(
        'https://segundo-parcial-si2.onrender.com/api/docente-materia/licencias/$registro',
        options: Options(
          headers: {
            'Authorization': 'Bearer $token',
          },
        ),
      );

      // Manejar la respuesta
      if (response.statusCode == 200) {
        final List<dynamic> materiasJson = response.data;
        List<AsistenciasModel> materias = materiasJson
            .map((json) => AsistenciasModel.fromJson(json))
            .toList();
        return materias;
      } else {
        throw Exception('Failed to load materias');
      }
    } catch (e) {
      throw Exception('Failed to load materias');
    }
  }
}
