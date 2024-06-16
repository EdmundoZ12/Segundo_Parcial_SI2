import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:jwt_decode/jwt_decode.dart';
import 'package:shared_preferences/shared_preferences.dart';

class AuthUtil {
  static Future<String?> getToken() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    return prefs.getString('token');
  }

  static Future<String?> getNroRegistro() async {
    String? token = await getToken();
    if (token != null) {
      Map<String, dynamic> payload = Jwt.parseJwt(token);
      return payload['nro_registro'];
    }
    return null;
  }

    static Future<String?> getNombre() async {
    String? token = await getToken();
    if (token != null) {
      Map<String, dynamic> payload = Jwt.parseJwt(token);
      return payload['nombre'];
    }
    return null;
  }

  static Future<void> logout(BuildContext context) async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    await prefs.remove('token');
    context.push("/login");
  }
}
