import 'package:app_movil_asistencia/pages/authUtil.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:app_movil_asistencia/config/menu/menu_item.dart';

class HomePage extends StatelessWidget {
  static const String name = 'home_screen';
  
  const HomePage({Key? key});

  Future<void> _logout(BuildContext context) async {
    await AuthUtil.logout(context);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: FutureBuilder<String?>(
          future: AuthUtil.getNombre(),
          builder: (context, snapshot) {
            if (snapshot.connectionState == ConnectionState.waiting) {
              return const Text('Home Loading...');
            } else if (snapshot.hasError) {
              return const Text('Home Error');
            } else if (!snapshot.hasData || snapshot.data == null) {
              return const Text('Home No Data');
            } else {
              return Text('Bienvenido Ing. ${snapshot.data}');
            }
          },
        ),
        actions: <Widget>[
          IconButton(
            icon: const Icon(Icons.logout),
            onPressed: () => _logout(context),
          ),
        ],
      ),
      body: const _HomeView(),
    );
  }
}

class _HomeView extends StatelessWidget {
  const _HomeView();

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemCount: appMenuItems.length,
      itemBuilder: (context, index) {
        final menuItem = appMenuItems[index];
        return _CustomListTile(menuItem: menuItem);
      },
    );
  }
}

class _CustomListTile extends StatelessWidget {
  const _CustomListTile({
    required this.menuItem,
  });

  final MenuItem menuItem;

  @override
  Widget build(BuildContext context) {
    final colors = Theme.of(context).colorScheme;
    return ListTile(
      leading: Icon(
        menuItem.icon,
        color: colors.primary,
      ),
      trailing: Icon(
        Icons.arrow_forward_ios_rounded,
        color: colors.primary,
      ),
      title: Text(menuItem.title),
      subtitle: Text(menuItem.subTitle),
      onTap: () {
        context.push(menuItem.link);
      },
    );
  }
}
