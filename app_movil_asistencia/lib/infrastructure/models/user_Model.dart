import 'package:flutter/material.dart';

class UserModel extends ChangeNotifier {
  String? nroRegistro;

  setNroRegistro(String nroRegistro) {
    this.nroRegistro = nroRegistro;
    notifyListeners();
  }
}
