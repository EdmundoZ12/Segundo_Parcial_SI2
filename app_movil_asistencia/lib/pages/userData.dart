import 'package:flutter/material.dart';

class UserData extends InheritedWidget {
  final String nroRegistro;

  UserData({
    required this.nroRegistro,
    required Widget child,
    Key? key,
  }) : super(key: key, child: child);

  static UserData? of(BuildContext context) {
    return context.dependOnInheritedWidgetOfExactType<UserData>();
  }

  @override
  bool updateShouldNotify(covariant InheritedWidget oldWidget) {
    return false;
  }
}
